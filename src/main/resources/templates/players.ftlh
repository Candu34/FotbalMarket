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
        <p><b>${player.name}</b></p>
        <#if player.currentTeam??>
        <p><b>${player.currentTeam.name}</b></p>
            <#else >
            <p>The player is current without team</p>
        </#if>

        <p>${player.price} usd.| <a href="/players/${player.id}">Details...</a></p>
    </div>
    <hr>
<#else >
    <h3>There is no players yet!</h3>
</#list>


    <h3>Add new player</h3>
    <form action="/players/create" method="post" enctype="multipart/form-data">
        Name of player: <input type="text" name="name"><br><br>
        Age: <input type="number" name="age"><br><br>
        Price: <input type="number" name="price"><br><br>
        Position: <input type="text" name="position"><br><br>
        Country: <input type="text" name="country"><br><br>
        Add photo: <input type="file" name="files" multiple><br><br>
        <input type="submit" value="Add player">
    </form>


</body>
</html>