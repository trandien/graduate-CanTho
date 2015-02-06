$(document).ready(
    function () {
        $(".list-title").click(
            function (e) {
                $(".editable").removeClass("editing");
                var editable = $(this).parent();
                editable.append($("#edit"));
                var field = editable.find("#edit > .form-group > .field");
                var id = editable.find(".list-id").text();
                editable.addClass("editing");

                $(".form-id").val(id);
                $(".form-id").attr("name", "maDanhSach");
                field.focus();
                field.val($(this).text());
                field.select();
            }
        );

        $(".checklist-item-title").click(
            function () {
                $(".editable").removeClass("editing");
                var editable = $(this).parent();
                editable.append($("#edit"));
                var field = editable.find("#edit > .form-group > .field");

                editable.addClass("editing");
                field.focus();
                field.val($(this).text());
                field.select();
            }
        );

        $(".card-title").click(
            function () {
                $(".editable").removeClass("editing");
                var editable = $(this).parent();
                editable.append($("#edit"));
                var field = editable.find("#edit > .form-group > .field");

                editable.addClass("editing");
                field.focus();
                field.val($(this).text());
                field.select();
            }
        );

        $(".project-title").click(
            function () {
                $(".editable").removeClass("editing");
                var editable = $(this).parent();
                editable.append($("#edit"));
                var field = editable.find("#edit > .form-group > .field");

                editable.addClass("editing");
                field.focus();
                field.val($(this).text());
                field.select();
            }
        );

        $(".list-item").click(
            function () {
                var title = $(this).children(".list-item-title").text();
                var id = $(this).children(".list-item-id").text();
                $(".modal-title").html(title);
                $(".modal-id").val(id);
                
                
            }
        );

        $(".cancel").click(
            function (e) {
                var editable = $(this).parent().parent().parent();
                editable.removeClass("editing");
            }
        );

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

        $("#btn-search").click(
            function () {
                $("#search-bar").toggleClass("search-bar-open");
            }
        )

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

        $("#btn-chat").tooltip({
            title: "Thảo luận",
            placement: "left",
            container: 'body'
        });

        $("#deadline").datepicker({
            format: 'dd/mm/yyyy'
        });


    }
);