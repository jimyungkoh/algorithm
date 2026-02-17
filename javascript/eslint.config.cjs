const js = require("@eslint/js");
const globals = require("globals");

module.exports = [
  {
    ignores: ["node_modules/**", "coverage/**"],
  },
  js.configs.recommended,
  {
    files: ["src/**/*.js", "__tests__/**/*.js"],
    languageOptions: {
      ecmaVersion: "latest",
      sourceType: "script",
      globals: {
        ...globals.node,
      },
    },
    rules: {
      // Keep TODO templates lintable while implementation is in progress.
      "no-unused-vars": ["warn", { args: "none" }],
      "indent": ["error", 2],
      "semi": ["error", "always"],
      "quotes": ["error", "double", { avoidEscape: true }],
      "comma-dangle": ["error", "always-multiline"],
      "object-curly-spacing": ["error", "always"],
      "array-bracket-spacing": ["error", "never"],
      "keyword-spacing": ["error", { before: true, after: true }],
      "space-infix-ops": "error",
      "space-in-parens": ["error", "never"],
      "no-trailing-spaces": "error",
      "eol-last": ["error", "always"],
    },
  },
  {
    files: ["__tests__/**/*.js"],
    languageOptions: {
      globals: {
        ...globals.jest,
      },
    },
  },
];
