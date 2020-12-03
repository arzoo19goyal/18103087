<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form >
        <input type="text" id="input_id" style="font-size:30px" value="">
        <input type="button" value="Submit" style="font-size:30px" onclick="balance()" />
        <div id="alert" style="color: red; font-size:50px" ></div>
    </form>
    <script src="brackets.js">
      function balance() {
        var variable = document.getElementById('input_id').value;

        const openers = ["{", "[", "("];
        const closers = ["}", "]", ")"];
        const match = {
          "}": "{",
          "]": "[",
          ")": "("
        };

        function myFunction(string) {
          // console.log(`"${string}"`);
          var stack = [];

          for (c in string) {
            if (openers.includes(string[c])) {
              stack.push(string[c]);
            }
            if (closers.includes(string[c])) {
              const last = stack.pop();
              if (last !== match[string[c]]) {
                return false;
              }
            }
//             else{
//               alert("Invalid input");
//             }
          }
          return stack.length === 0; 
        }

        document.getElementById('alert').innerHTML = myFunction(variable);
      }
      </script>
</body>
</html>
