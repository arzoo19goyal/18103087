const openers = ["{", "[", "("];
const closers = ["}", "]", ")"];
const match = {
  "}": "{",
  "]": "[",
  ")": "("
};

function myFunction(string) {
  console.log(`"${string}"`);
  var stack = [];

  for (c in string) {
    if (openers.includes(string[c])) {
      stack.push(string[c]);
    }
    if (closers.includes(string[c])) {
      const last = stack.pop();
      if (last !== match[string[c]]) {
        document.write(string);
        return false;
      }
    }
  }
  document.write(string);
  return stack.length === 0; 
}

function test(actual, expected) {
  document.write("&nbsp&nbsp", "actual:", actual,"&nbsp&nbsp", ",expected:", expected);
  document.write("<br>");
}
test(myFunction(""), true);
test(myFunction("{{{}}}]"), false);
test(myFunction("{"), false);
test(myFunction("}"), false);
test(myFunction("{ [ ] ( { [ ] } ) }"), true);
test(myFunction("{ [ () ] ( ) }"), true);
test(myFunction("{ [ ( ] ) ( ) }"), false);
test(myFunction("{ [ ( ] ) }"), false);
test(myFunction("{ [ }"), false);
