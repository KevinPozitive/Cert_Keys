{var x = 0;

function addInput() {
    if (x < 10) {
        var str = '        <div class="container">\n' +
            '            <div class="form-group row">\n' +
            '                <div class="col-sm-2">\n' +
            '                    <label for="firstName" class="col-sm-2 col-form-label col-form-label-sm">Имя</label>\n' +
            '                </div>\n' +
            '                <div class="col-sm-4">\n' +
            '                    <input type="text" class="form-control form-control-sm" id = "firstName" >\n' +
            '                </div>\n' +
            '            </div>\n' +
            '            <div class="form-group row">\n' +
            '                <div class="col-sm-2">\n' +
            '                    <label for="secondName" class="col-sm-2 col-form-label col-form-label-sm">Фамилия</label>\n' +
            '                </div>\n' +
            '                <div class="col-sm-4">\n' +
            '                    <input type="text" class="form-control form-control-sm" id = "secondName" >\n' +
            '                </div>\n' +
            '            </div>\n' +
            '            <div class="form-group row">\n' +
            '                <div class="col-sm-2">\n' +
            '                    <label for="lastName" class="col-sm-2 col-form-label col-form-label-sm">Отчество</label>\n' +
            '                </div>\n' +
            '                <div class="col-sm-4">\n' +
            '                    <input type="text" class="form-control form-control-sm" id = "lastName" >\n' +
            '                </div>\n' +
            '            </div>\n' +
            '            <div class="form-group row">\n' +
            '                <div class="col-sm-2">\n' +
            '                    <label for="organ" class="col-sm-2 col-form-label col-form-label-sm">Орган</label>\n' +
            '                </div>\n' +
            '                <div class="col-sm-4">\n' +
            '                    <input type="text" class="form-control form-control-sm" id = "organ" >\n' +
            '                </div>\n' +
            '            </div>\n' +
            '            <div class="form-group row">\n' +
            '                <div class="col-sm-2">\n' +
            '                    <label for="position" class="col-sm-2 col-form-label col-form-label-sm">Должность</label>\n' +
            '                </div>\n' +
            '                <div class="col-sm-4">\n' +
            '                    <input type="text" class="form-control form-control-sm" id = "position" >\n' +
            '                </div>\n' +
            '            </div>\n' +
            '            <div class="form-group row">\n' +
            '                <div class="col-sm-2">\n' +
            '                    <label for="reason" class="col-sm-2 col-form-label col-form-label-sm">Основание</label>\n' +
            '                </div>\n' +
            '                <div class="col-sm-4">\n' +
            '                    <input type="text" class="form-control form-control-sm" id = "reason" >\n' +
            '                </div>\n' +
            '            </div>\n' +
            '            <hr style="width:100%;text-align-all:left;">\n' +
            '        </div>' +
            '        <div id="input' + (x + 1) + '"></div>';
        document.getElementById('input' + x).innerHTML = str;
        x++;
    } else
    {
        alert('Максимальное кол-во участников!');
    }
}}