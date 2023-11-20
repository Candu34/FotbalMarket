<!DOCTYPE html>
<html>
<body>

<h1>Market Place </h1>
<hr>

<form action="/" method="get">
    Search teams by name <input type="text" name="name"><br>
    <input type="submit" value="Search!">
</form>

<#list teams as team>
    <div>
        <p><b>${team.name}</b></p>
        <p>${team.championate} <a href="/teams/${team.id}">Details...</a></p>
    </div>
    <hr>
<#else >
    <h3>There is no teams yet!</h3>
</#list>


    <h3>Add new team</h3>

<form action="/teams/create" method="post" enctype="multipart/form-data">
    Name of the team: <input type="text" name="name"><br><br>
    Country: <input type="text" name="country"><br><br>
    Championate: <input type="text" name="championate"><br><br>
    Manager: <input type="text" name="manager"><br><br>
    Add photo: <input type="file" name="files" multiple><br><br>
    <input type="submit" value="Add team">
</form>



</body>
</html>