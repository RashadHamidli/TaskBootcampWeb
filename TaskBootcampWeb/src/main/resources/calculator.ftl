<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculate" method="get">
    <label for="num1">Number 1:</label>
    <input type="text" id="num1" name="num1"><br>

    <label for="num2">Number 2:</label>
    <input type="text" id="num2" name="num2"><br>

    <input type="submit" value="Add">
</form>
<h2>Result: ${result}</h2>
</body>
</html>
