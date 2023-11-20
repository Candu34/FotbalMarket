<!DOCTYPE html>
<html>
<body>

<div>
    <p>Name: ${player.name}</p><hr/>
    <p>Country: ${player.country}</p>
    <#if player.currentTeam??>
        <p><b>${player.currentTeam.name}</b></p>
    <#else >
        <p>The player is current without team</p>
    </#if>
    <#list images as image>
        <img src="/images/${image.id}" alt="">
        <br><br>
    </#list>
    <p>Rating: </p>
    <#if rating??>
        <p>Position: ${player.position}</p>
        <p>Price on market: ${player.price}</p>
        <p>Ratings: </p><hr/>
        <p>Defence: ${rating.defence}</p>
        <p>Dribling: ${rating.dribling}</p>
        <p>Pace: ${rating.pace}</p><br/>
        <p>Passing: ${rating.passing}</p><br/>
        <p>Physic: ${rating.physic}</p><br/>
        <p>Shooting: ${rating.shooting}</p><br/>
    <#else >
        <p>The player is current without rating</p>
        <h3>Add player rating</h3>
        <form action="/rating/create" method="post">
            <label for="pace">Pace:</label>
            <input type="number" id="pace" name="pace" required><br>

            <label for="shooting">Shooting:</label>
            <input type="number" id="shooting" name="shooting" required><br>

            <label for="passing">Passing:</label>
            <input type="number" id="passing" name="passing" required><br>

            <label for="dribbling">Dribbling:</label>
            <input type="number" id="dribbling" name="dribbling" required><br>

            <label for="defence">Defence:</label>
            <input type="number" id="defence" name="defence" required><br>

            <label for="physic">Physic:</label>
            <input type="number" id="physic" name="physic" required><br>

            <input type="hidden" id="playerId" name="playerId" value="${player.id}"><br>

            <button type="submit">Submit</button>
        </form>
    </#if>

</div>


</body>
</html>