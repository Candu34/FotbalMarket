<!DOCTYPE html>
<html>
<body>

<h1>Market Place </h1>
<hr>

<form action="/" method="get">
    Search products by name <input type="text" name="name"><br>
    <input type="submit" value="Search!">
</form>

<#list teams as team>
    <div>
        <p><b>${team.name}</b></p>
        <p>${team.country} usd.| <a href="/product/${team.id}">Details...</a></p>
    </div>
    <hr>
<#else >
    <h3>There is no teams yet!</h3>
</#list>


    <h3>Add new team</h3>
    <form action="/product/create" method="post" enctype="multipart/form-data">
        Title of product: <input type="text" name="title"><br><br>
        Description: <input type="text" name="description"><br><br>
        Price: <input type="number" name="price"><br><br>
        City: <input type="text" name="city"><br><br>
        Add photo: <input type="file" name="files" multiple><br><br>
        <input type="submit" value="Add product">
    </form>



</body>
</html>