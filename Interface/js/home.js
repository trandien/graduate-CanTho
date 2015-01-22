$(document).on('click', '.plan-delete', function (e) {
    var fpd = $("#form-plan-delete");
    if (fpd.css("display") != "none") return;
    var pos = $(this).offset();
    var x = pos.left;
    var y = pos.top + $(this).height() + 5;

    $("#form-plan-delete").css({
        "left": x + "px",
        "top": y + "px"
    })

    $("#form-plan-delete").show("fast");
    var mkh = $(this).children(".plan-delete-val").val();
    $("#form-makehoach").val(mkh);
});

$(document).on('click', '.plan', function () {
    var href = $(this).children(".plan-header").children(".plan-title").attr("href");
    window.location.href = href;
});

$(document).ready(
    function () {
        $(".project-list").niceScroll({
            cursorcolor: "#e6e6e6",
            cursorwidth: "8px",
            cursorborderradius: "10px",
            scrollspeed: 80,
            mousescrollstep: 40,
            touchbehavior: true,
            zindex: 1000,
            horizrailenabled: true
        });

        $(".toggle").click(
            function () {
                var index = $(this).index();
                $('.panel-container').eq(index).toggle().siblings('.panel-container').hide();
            }
        );

        $(document).mousedown(function (e) {
            var container = $(".panel-create-project");
            var datepicker = $(".datepicker");
            if (!container.is(e.target) && container.has(e.target).length === 0 && !datepicker.is(e.target) && datepicker.has(e.target).length === 0) {
                container.hide("fast");
            }

            container = $("#form-plan-delete");
            if (!container.is(e.target) && container.has(e.target).length === 0)
                container.hide("fast");
        });

        $(".btn-create-project").click(
            function (e) {
                var pcp = $(".panel-create-project");
                if (pcp.css("display") != "none") return;
                var pos = $(this).offset();
                var x = pos.left;
                var y = pos.top;

                if (!$(this).hasClass("btn-create-project"))
                    y = y + $(this).outerHeight();
                //alert("x = " + x + "y = " + y);
                $(".panel-create-project").css({
                    "left": x + "px",
                    "top": y + "px"
                })
                $(".panel-create-project").show("fast");
                $("#project-title").focus();
            }
        );

        $(".plan-delete").click(
            function (e) {
                var fpd = $("#form-plan-delete");
                if (fpd.css("display") != "none") return;
                var pos = $(this).offset();
                var x = pos.left;
                var y = pos.top + $(this).height() + 5;

                $("#form-plan-delete").css({
                    "left": x + "px",
                    "top": y + "px"
                })

                $("#form-plan-delete").show("fast");
                var mkh = $(this).children(".plan-delete-val").val();
                $("#form-makehoach").val(mkh);
            }
        );



        $("#btn-notification").tooltip({
            title: "Thông báo",
            placement: "left",
            container: 'body'
        });

        $("#btn-project").tooltip({
            title: "Kế hoạch",
            placement: "left",
            container: 'body'
        });

        $(".datepicker").datepicker({
            format: 'dd/mm/yyyy'
        });
    }
);