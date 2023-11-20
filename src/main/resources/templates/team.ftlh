<!DOCTYPE html>
<html>
<body>

<div>
    <p>Name: ${team.name}</p>
    <hr/>
    <p>Country: ${team.country}</p>
    <p>Championate: ${team.championate}</p>
    <p>Manager: ${team.manager}</p>
    <#if players??>
        <#list players as player>
            <p>${player.name} | ${player.country}</p>
            <br>
        </#list>
    <#else >
        <p>The team has no players</p>
    </#if>
    <#list images as image>
        <img src="/images/${image.id}" alt="">
        <br><br>
    </#list>
</div>

</body>
</html>