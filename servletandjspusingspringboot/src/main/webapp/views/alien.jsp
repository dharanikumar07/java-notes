<%@ page language="java"%>

<!DOCTYPE html>
<html>
  <head>
    <title>Add alien</title>
    <link rel="stylesheet" type="text/css" href="style.css" />

  </head>
  <body>
    <div class="container">
      <h1>Add Alien</h1>

      <form action="/view-alien" method="get">
        <label>Name</label>
        <input
          type="text"
          name="name"
          placeholder="Enter Name"
          required
        />

        <label>Age</label>
        <input
          type="number"
          name="age"
          placeholder="Enter age"
          required
        />

        <button type="submit">View Result</button>
      </form>
    </div>
  </body>
</html>
