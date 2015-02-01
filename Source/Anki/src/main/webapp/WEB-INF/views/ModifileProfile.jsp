<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Anki</title>

<link
	href="<c:url value = "http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300|Roboto+Condensed|Roboto:400,300,500,700&subset=latin,vietnamese" />"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/resources/css/bootstrap.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/resources/custom/profile.css" />" />
<script src="<c:url value = "/resources/js/jquery-1.11.1.min.js" />"
	type="text/javascript"></script>
<script src="<c:url value = "/resources/js/bootstrap.min.js" />"
	type="text/javascript"></script>
<script src="<c:url value = "/resources/js/profile.js" />"
	type="text/javascript"></script>
	
<script src="<c:url value = "/resources/ajax/ajaxNguoiDung.js"/>"></script>

</head>

<body>
	<!-- Edit checklist-item -->
	<form id="edit">
		<input class="sr-only" value="" />
		<textarea type="text" class="field form-control" style="height: 66px;"
			autofocus></textarea>
		<div class="form-group">
			<button type="submit" class="btn btn-success btn-save">Lưu</button>
			<button type="button" class="close cancel">
				<span aria-hidden="true">&times;</span><span class="sr-only">ÄÃ³ng</span>
			</button>
		</div>
	</form>
	<!-- Edit checklist-item -->
	<!-- /. PROFILE -->
	<div class="bubble panel panel-default panel-container"
		id="panel-profile" style="display: none;">
		<div class="panel-body">
			<div class="avatar">
				<c:choose>

					<img src="<c:url value = "/resources/img/user91.png" />" class="img-responsive">


				</c:choose>
			</div>
			<div style="display: inline-block; color: white; padding-left: 20px;">
				<div id="bubble-name" style="font-size: 24px;">Trần Thanh Điền</div>
				<div>kudoedogava@gmail.com</div>

				<hr>

			</div>
		</div>
		<div class="panel-footer text-right">
			<a class="btn btn-primary" href="Dang-Nhap-Page.htm">Đăng xuất</a>
		</div>
	</div>
	<!-- /. PROFILE -->

	<!-- SIDEBAR PANEL -->
	<ul id="project-panel" class="col-lg-3 panel-container"
		style="display: none;">
		<li>
			<div class="project-panel-brand">Danh sách</div>
		</li>
		<hr />
		xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
	</ul>
	<!-- /.SIDEBAR PANEL -->

	<!-- Sidebar -->
	<div id="sidebar-wrapper">
		<ul class="sidebar-nav">
			<li id="btn-profile" class="toggle">
				<div>
					<c:choose>

						<img src="<c:url value = "/resources/img/user91.png" />" class="img-responsive">


					</c:choose>
				</div>
			</li>

			<li id="btn-project" class="toggle">
				<div class="flaticon-lg">
					<i class="flaticon-project"></i>
				</div>
			</li>
		</ul>
	</div>
	<!-- /#sidebar-wrapper -->
	<p class="bg-success"
		style="display: none; position: absolute; z-index: 9999; padding: 10px; bottom: 10px; right: 100px;">Lưu thông tin thành công</p>
	<div id="wrapper">
		<!-- Page Content -->
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<div class="row" style="margin-left: -35px; margin-right: -35px;">
					<header class="navbar navbar-inverse navbar-fixed-top"
						style="margin-bottom: 0px;" role="navigation">
					<div class="container-fluid">
						<div class="row">
							<div class="navbar-header col-sm-6 col-md-6 col-lg-6">
								<button type="button" class="navbar-toggle collapsed"
									data-toggle="collapse" data-target="#navbar-collapse">
									<span class="sr-only">Toggle navigation</span> <span
										class="icon-bar"></span> <span class="icon-bar"></span> <span
										class="icon-bar"></span>
								</button>
								<div class="navbar-brand editable">
									<a href="home.jsp">Anki</a>

								</div>
							</div>
							<!-- Collect the nav links, forms, and other content for toggling -->

							<!-- /.navbar-collapse -->
						</div>
						<!-- .row -->
					</div>
					<!-- /.container-fluid --> </header>
				</div>

				<div class="row profile-container">

					<div class="profile-base">
						<div id="profile-avatar">
							<c:choose>

								<img id="uploadPreview" src="<c:url value = "/resources/img/user91.png"/>"
									class="img-responsive">

							</c:choose>
						</div>
						<div id="profile-basic">
							<div id="profile-name">Trần Thanh Điền</div>
							<div id="profile-email">kudoedogava@gmail.com</div>
						</div>
					</div>

					<form role="form" class="form-horizontal active tab-pane"
						id="profile-form-info" onSubmit="ajaxLuuThongTin()"
						enctype="multipart/form-data">

						<div class="form-group">
							<label for="profile-name-edit"
								class="col-sm-4 col-lg-4 control-label">Há» tÃªn</label>
							<div class="col-sm-8 col-lg-8">
								<input name="hoTen" class="form-control" id="profile-name-edit"
									type="text" placeholder="Há» tÃªn"
									value="Trần Thanh Điền">
							</div>
						</div>
						<!--     <div class="form-group">
                            <label for="profile-username-edit" class="col-sm-4 col-lg-4 control-label">TÃ i khoáº£n</label>
                            <div class="col-sm-8 col-lg-8">
                                <input class="form-control" id="profile-username-edit" type="text" placeholder="TÃªn tÃ i khoáº£n">
                            </div>
                        </div>
                         -->
						<input name="taiKhoan" value="kudoedogava@gmail.com" type="hidden">
						<div class="form-group">
							<label for="profile-email-edit"
								class="col-sm-4 col-lg-4 control-label">Email</label>
							<div class="col-sm-8 col-lg-8">
								<input name="taiKhoan" value="kudoedogava@gmail.com"
									class="form-control" id="profile-email-edit" type="text"
									disabled>
							</div>
						</div>

						<div class="form-group">
							<label for="image" class="col-sm-4 col-lg-4 control-label">Äá»i
								hÃ¬nh Äáº¡i diá»n</label>
							<div class="col-sm-8 col-lg-8">
								<div id="change-avatar"
									style="border: 1px solid #dfdfdf; background: #fff; padding: 7px; width: 160px;">
									Thay Äá»i áº£nh Äáº¡i diá»n</div>
								<input name="file" type="file" id="image"
									onchange="PreviewImage();" style="display: none;">
							</div>
						</div>

						<hr />
						<div class="form-group">
							<label for="old-pass" class="col-sm-4 col-lg-4 control-label">Máº­t
								kháº©u cÅ©</label>
							<div class="col-sm-8 col-lg-8">
								<input name="matKhauCu" class="form-control" id="old-pass"
									type="password" placeholder="Máº­t kháº©u cÅ©">
							</div>
						</div>
						<div class="form-group">
							<label for="new-pass" class="col-sm-4 col-lg-4 control-label">Máº­t
								kháº©u má»i</label>
							<div class="col-sm-8 col-lg-8">
								<input name="matKhauMoi" class="form-control" id="new-pass"
									type="password" placeholder="Máº­t kháº©u má»i">
							</div>
						</div>
						<div class="form-group">
							<label for="repeat-new-pass"
								class="col-sm-4 col-lg-4 control-label">Nháº­p láº¡i
								máº­t kháº©u má»i</label>
							<div class="col-sm-8 col-lg-8">
								<input name="nhacLaiMatKhauMoi" class="form-control"
									id="repeat-new-pass" type="password"
									placeholder="Nháº­p láº¡i máº­t kháº©u má»i">
							</div>
						</div>
						<button type="submit" class="btn btn-primary">LÆ°u thÃ´ng
							tin</button>
					</form>
				</div>
			</div>
		</div>
		<!-- /#page-content-wrapper -->
	</div>
</body>
<script>
	$("form").submit(function(e) {
		e.preventDefault();
	});

	function Validate() {
		var image = document.getElementById("image").value;
		if (image != '') {
			var checkimg = image.toLowerCase();
			if (!checkimg.match(/(\.jpg|\.png|\.JPG|\.PNG|\.jpeg|\.JPEG)$/)) {
				alert("Báº¡n vui lÃ²ng chá»n áº£nh cÃ³ pháº§n má» rá»ng lÃ : .jpg,.png,.jpeg");
				document.getElementById("image").focus();
				return false;
			}
		}
		return true;
	}

	function PreviewImage() {
		var oFReader = new FileReader();
		oFReader.readAsDataURL(document.getElementById("image").files[0]);

		oFReader.onload = function(oFREvent) {
			document.getElementById("uploadPreview").src = oFREvent.target.result;
			//alert(oFREvent.target.result);
		}
	};

	$("#change-avatar").click(function() {
		$("#image").click();
	});
</script>

</html>