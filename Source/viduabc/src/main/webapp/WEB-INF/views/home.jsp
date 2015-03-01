<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Anki</title>
    <link href="http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300|Roboto+Condensed|Roboto:400,300,500,700&subset=latin,vietnamese" rel="stylesheet" type="text/css" />
    
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="custom/home.css" />
    <script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <script src="js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="js/home.js" type="text/javascript"></script>
    <script src="js/bootstrap-datepicker.js" type="text/javascript"></script>
	<meta name="description" content="Awesome Bubble Navigation with jQuery" />
        <meta name="keywords" content="jquery, circular menu, navigation, round, bubble"/>
        <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
        <style>
            *{
                margin:0;
                padding:0;
            }
            body{
                font-family:Arial;
                
            }
            .title{
                width:548px;
                height:119px;
                position:absolute;
                top:400px;
                left:150px;
                background:transparent url(title.png) no-repeat top left;
            }
            a.back{
                background:transparent url(back.png) no-repeat top left;
                position:fixed;
                width:150px;
                height:27px;
                outline:none;
                bottom:0px;
                left:0px;
            }
            #content{
                margin:0 auto;
            }
        </style>

         <!-- The JavaScript -->
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
        <script type="text/javascript" src="jquery.easing.1.3.js"></script>
        <script type="text/javascript">
            $(function() {
                $('#nav > div').hover(
                function () {
                    var $this = $(this);
                    $this.find('img').stop().animate({
                        'width'     :'199px',
                        'height'    :'199px',
                        'top'       :'-25px',
                        'left'      :'-25px',
                        'opacity'   :'1.0'
                    },500,'easeOutBack',function(){
                        $(this).parent().find('ul').fadeIn(700);
                    });

                    $this.find('a:first,h2').addClass('active');
                },
                function () {
                    var $this = $(this);
                    $this.find('ul').fadeOut(500);
                    $this.find('img').stop().animate({
                        'width'     :'52px',
                        'height'    :'52px',
                        'top'       :'0px',
                        'left'      :'0px',
                        'opacity'   :'0.1'
                    },5000,'easeOutBack');

                    $this.find('a:first,h2').removeClass('active');
                }
            );
            });
        </script>
    </head>


<body>

	<header class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="row">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#"><h3>Anki</h3></a>
                </div>
            </div> <!-- .row -->
     	</div>  
    </header> <!-- /.container-fluid -->


    <!-- Form Xóa kế hoạch -->
    <div id="form-plan-delete" style="display: none">
        <div class="form-header">Xóa kế hoạch</div>
        <hr />
        <div class="form-body">Bạn có chắc chắn muốn xóa kế hoạch này ?
            Chú ý: kế hoạch đã xóa không thể khôi phục</div>
        <input id="form-makehoach" type="hidden" value="" />
        <input id="taiKhoan" type="hidden" name="taiKhoan" value="" />
        <button onclick="ajaxXoaKeHoach()" class="btn btn-danger btn-block">
            Đồng ý</button>
    </div>
    <!-- /.Form Xóa kế hoạch -->
    
    <!-- Sidebar -->
    <div id="sidebar-wrapper">
        <ul class="sidebar-nav">
            <li id="btn-profile" class="toggle" data-toggle="tooltip">
                <div>
                    <img src="img/user91.png" class="img-responsive">
                </div>
            </li>
            <li id="btn-notification" class="toggle" data-toggle="tooltip" data-placement="left">
                <div class="flaticon-lg"><i class="flaticon-notification"></i>
                    <!--<br>THÔNG BÁO--></div>
            </li>
            <li id="btn-project" class="toggle" data-toggle="tooltip">
                <div class="flaticon-lg"><i class="flaticon-project"></i>
                </div>    <!--<br>KẾ HOẠCH-->
            </li>
        </ul>
    </div>
    <!-- /.sidebar-wrapper -->
    
    <!-- CREATE PROJECT PANEL -->
    
    </div>
    <!-- CREATE PROJECT PANEL -->
    <!-- /. PROFILE -->
    <div class="bubble panel panel-default panel-container" id="panel-profile" style="display: none;">
        <div class="panel-body">
            <div class="avatar"><img src="img/user91.png" class="img-responsive"></div>
            <div style="display: inline-block; color: white; padding-left: 20px;">
                <div style="font-size: 24px;">Trần Thanh Điền</div>
                <div>kudoedogava@gmail.com</div>

                <hr>
                <div style="padding-left: 10px;"><a href="ModifileProfile.html">Xem thông tin cá nhân</a>
                </div>
            </div>
        </div>
        <div class="panel-footer text-right">
            <button class="btn btn-primary">Đăng xuất</button>
        </div>
    </div>
    <!-- /. PROFILE -->

   <div class="container">
   		
            <div class="row">
                <div class="navigation" id="nav">
                    <div class="col-md-3 col-sm-3 col-lg-3 col-xs-3">
                        <div class=" form-group">
                             <div class="item user">
                                <img src="images/bg_user1.png" alt="" width="199" height="199" class="circle"/>
                                <a href="#" class="icon"></a>
                                <h2>User</h2>
             
                            </div>
                        </div>
                    </div>
            
                    <div class="col-md-3 col-sm-3 col-lg-3 col-xs-3">
                        <div class=" form-group">
                            <div class="item home">
                                <img src="images/bg_home1.png" alt="" width="199" height="199" class="circle"/>
                                <a href="#" class="icon"></a>
                                <h2>Home</h2> 
                            </div>
                        </div>
                    </div>
         
                    <div class="col-md-3 col-sm-3 col-lg-3 col-xs-3">
                        <div class=" form-group">   
                            <div class="item shop">
                                <img src="images/bg_shop1.png" alt="" width="199" height="199" class="circle"/>
                                <a href="#" class="icon"></a>
                                <h2>Shop</h2>                 
                            </div>
                        </div>
                    </div>
            
                    <div class="col-md-3 col-sm-3 col-lg-3 col-xs-3">
                        <div class=" form-group">
                            <div class="item camera">
                                <img src="images/bg_camera1.png" alt="" width="199" height="199" class="circle"/>
                                <a href="#" class="icon"></a>
                                <h2>Photos</h2>    
                            </div>
                        </div>
                    </div> <!-- end navigation -->
                </div> <!--end row-->
            </div><!--end container-->
        <!--end container-->

   </div>
   
   


</body>

</html>
