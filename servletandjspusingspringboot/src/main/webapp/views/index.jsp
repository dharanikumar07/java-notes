<%@ page language="java"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Addition Calculator</title>
    <link rel="stylesheet" type="text/css" href="style.css" />

  </head>
  <body>
    <div class="container">
      <h1>Addition Calculator</h1>
      <p>Enter two numbers to calculate their sum.</p>

      <form action="/add" method="get">
        <label>First Number</label>
        <input
          type="number"
          name="num1"
          placeholder="Enter first number"
          required
        />

        <label>Second Number</label>
        <input
          type="number"
          name="num2"
          placeholder="Enter second number"
          required
        />

        <button type="submit">Add Numbers</button>
      </form>
    </div>
  </body>
</html>
