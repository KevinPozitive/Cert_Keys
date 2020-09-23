document.getElementById('numb').oninput = function () {
    if (this.value.length > 5) this.value = this.value.substr(1, 5);
} // в поле можно ввести только 5 символов