<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Movie List</title>
</head>
<body>
<h1>Movie List</h1>

<br/><br/>
<div>
    <table border="1">
        <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Extra Options</th>


        </tr>
        <c:forEach  items="${movies}" var ="movie">
            <tr>
                <td>${movie.title}</td>
                <td>${movie.description}</td>
                <td>
                    <form method="post" action="/movie/${movie.id}">
                        <input type="hidden"  name="_method" value="DELETE">
                        <input type="submit" value="Delete"/>
                    </form>
                    <button onclick="window.location.href='movie/${movie.id}'">Edit</button>
                </td>
            </tr>
        </c:forEach>
    </table>

    <br/>
    <div>
        <h3>Add movie</h3>
        <form method="post" action="/addMovie">
            <input name="title" value="Title">
            <input type="hidden"  name="id" value="0">
            <input name="description" value="Description">
            <input type="submit" value="Submit" />
        </form>
    </div>
</div>
</body>

</html>