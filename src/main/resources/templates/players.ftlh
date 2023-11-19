<!DOCTYPE html>
<html>
<body>

<h1>Zatic Market </h1>
<hr>

<form action="/" method="get">
    Search players by name <input type="text" name="country"><br>
    <input type="submit" value="Search!">
</form>

<#list players as player>
    <div>
        <p><b>${player.name}</b></p><br/>
        <p><b>${player.currentTeam.name}</b></p><br/>
        <p>${player.price} usd.| <a href="/player/${player.id}">Details...</a></p>
    </div>
    <hr>
<#else >
    <h3>There is no players yet!</h3>
</#list>


    <h3>Add new player</h3>
    <form action="/product/create" method="post" enctype="multipart/form-data">
        Name of player: <input type="text" name="name"><br><br>
        Age: <input type="number" name="age"><br><br>
        Price: <input type="number" name="price"><br><br>
        Position: <input type="text" name="position"><br><br>
        Country: <input type="text" name="country"><br><br>
        Position: <input type="text" name="position"><br><br>

<#--        Add photo: <input type="file" name="files" multiple><br><br>-->
        <input type="submit" value="Add player">
    </form>


</body>
</html>