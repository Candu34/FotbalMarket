<!DOCTYPE html>
<html>
<head>

</head>
<body>
<div id="demo"></div>


<h1>Static Resources Loader</h1>
<hr>

<h3>Upload an image</h3>
<form action="/static/loadImage" method="post" enctype="multipart/form-data">
    <label for="file">Choose an image:</label>
    <input type="file" id="file" name="file" accept="image/*" required>
    <br>
    <button type="submit">Upload</button>
</form>


</body>
</html>