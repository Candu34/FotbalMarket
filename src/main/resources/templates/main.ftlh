<!doctype html>
<html lang="en">
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

<div class="field container" style="height: 94vh;">
    <div class="row m-0 p-0">
        <p class="d-inline-flex gap-1">
            <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                    <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
                </svg>
            </button>
        </p>
        <div class="collapse" id="collapseExample">
            <div class="form-outline" data-mdb-input-init >
                <form method="get" action="/players">
                    <div class="form-group col-md-10">
                        <label class="form-label" for="name">Search team by name</label>
                        <input type="text" name="name" <#if name??>value="${name}"</#if> class="form-control"
                               id="name">
                        <button style="margin-top: 10px" type="submit" class="btn btn-primary" data-mdb-ripple-init>
                            Search
                        </button>
                    </div>
                </form>
            </div>
            <div>
                <div class="form-outline" data-mdb-input-init>
                    <form method="get" action="/players/rating">
                        <label for="overall" class="form-label">Search by overall rating</label>
                        <input type="range" value="50" name="overall" class="form-range" min="1" max="100" step="1"
                               id="overall"
                               oninput="this.nextElementSibling.value = this.value">
                        <output>50</output>
                        <button style="margin-top: 10px" type="submit" class="btn btn-primary" data-mdb-ripple-init>
                            Search
                        </button>
                    </form>
                </div>
            </div>
        </div>




        <!-- Card -->
        <#list players as player>
            <div class="col-12 col-md-6 my-2">
                <div class="card rounded shadow card-bleed border-0">
                    <div class="card-body">
                        <div class="row m-1">
                            <!-- Heading -->
                            <a href="/players/${player.id}" class="fw-bold mb-4 pb-2 ps-0 pe-0">${player.name}</a>
                            <p class="text-muted fw-bold p-0 m-0">
                                <#assign x = "null">
                                <#list images as image>
                                    <#if image.player.id = player.id>
                                        <img src="/images/${image.id}" alt="" height="200">
                                        <#assign x = image.name>
                                    </#if>
                                </#list>
                                <#if x == "null" >
                                    <img src="${unknownImage}" alt="">
                                </#if>
                            </p>
                            <div>
                                <p>Country: ${player.country}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        <#else >
            <h3>There is no players yet!</h3>

        </#list>
    </div>
</div>
</body>
</html>