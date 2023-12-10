<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="../static/css/style.css"/>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.7/dist/umd/popper.min.js"
            integrity="sha384-zYPOMqeu1DAVkHiLqWBUTcbYfZ8osu1Nd6Z89ify25QV9guujx43ITvfi12/QExE"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.min.js"
            integrity="sha384-Y4oOpwW3duJdCWv5ly8SCFYWqFDsfob/3GkgExXKV4idmbt98QcxXYs9UoXAB7BZ"
            crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.js"></script>
    <script src="../js/script.js"></script>
    <title>Zatic Market</title>
</head>
<body>
<div class="container">
    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3">
        <div class="col-md-3 mb-2 mb-md-0">
            <a class="d-inline-flex link-body-emphasis text-decoration-none">
                <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor"
                     class="bi bi-graph-up" viewBox="0 0 16 16">
                    <path fill-rule="evenodd"
                          d="M0 0h1v15h15v1H0zm14.817 3.113a.5.5 0 0 1 .07.704l-4.5 5.5a.5.5 0 0 1-.74.037L7.06 6.767l-3.656 5.027a.5.5 0 0 1-.808-.588l4-5.5a.5.5 0 0 1 .758-.06l2.609 2.61 4.15-5.073a.5.5 0 0 1 .704-.07Z"/>
                </svg>
            </a>
        </div>

        <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
            <li><a href="/players" class="nav-link px-2 link-secondary">Players</a></li>
            <li><a href="/teams" class="nav-link px-2">Teams</a></li>
            <li><a href="/players/add" class="nav-link px-2">Add player</a></li>
            <li><a href="/teams/add" class="nav-link px-2">Add Team</a></li>
            <li><a href="#" class="nav-link px-2">About</a></li>
        </ul>

        <div class="col-md-3 text-end">
<#--            <button type="button" class="btn btn-outline-primary me-2">Login</button>-->
<#--            <button type="button" class="btn btn-primary">Sign-up</button>-->
        </div>
    </header>
</div>
<div style="margin-left: 40px">
    <p>Name: ${team.name}</p>
    <hr/>
    <p>Country: ${team.country}</p>
    <p>Championate: ${team.championate}</p>
    <p>Manager: ${team.manager}</p>
    <h4>Players: </h4>
    <#list players as player>
        <a href="/players/${player.id}" style="margin-bottom: 10px">${player.name} | ${player.country}</a>
        <br>
    <#else >
        <p><i>The team has no players yet</i></p>
    </#list>

    <#list images as image>
        <img src="/images/team/${image.id}" alt="" height="200">
        <br><br>
    </#list>
</div>

<div style="margin-left: 40px">
    <form action="/teams/delete/${team.id}" method="post">
        <input type="hidden" name="_method" value="delete"/>
        <button type="submit">Delete Team</button>
    </form>
</div>

</body>
</html>