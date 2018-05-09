<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<!-- レスポンシブWebデザインを使うために必要なmetaタグ -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>PAGE1</title>
	<link href="/css/bootstrap.min.css" rel="stylesheet"></link>
	<script src="/js/jquery-3.3.1.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
</head>
<body>
	<form action="/page2" class="form-horizontal">
		<div class="form-group">
			<label for="name" class="control-label col-sm-2">Name:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="name" name="name">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-primary">送信</button>
			</div>
		</div>
	</form>
</body>
</html>
