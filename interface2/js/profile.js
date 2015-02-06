$(document).ready(
    function () {
        $("#btn-search").click(
            function () {
                $("#search-bar").toggleClass("search-bar-open");
            }
        )
        
        $(document).mousedown(function (e) {
            var container = $(".editable");
            if (!container.is(e.target) && container.has(e.target).length === 0)
                container.removeClass("editing");
        });

        $(".toggle").click(
            function () {
                var index = $(this).index();
                $('.panel-container').eq(index).toggle().siblings('.panel-container').hide();
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

        $("#btn-group").tooltip({
            title: "Nhóm",
            placement: "left",
            container: 'body'
        });
    }
);