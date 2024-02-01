function updateCart(seri, price) {
    var quantity = document.getElementById("quantityInput" + seri).value;

    $.ajax({
        url: 'cart',
        method: 'GET',
        data: {
            seri: seri,
            update: 1,
            quantity: quantity,
            price: price
        },
        success: function (response) {
            // Xử lý phản hồi từ server (nếu cần)
            console.log(response);
            // Update the total price dynamically
            var totalPrice = parseFloat(response.totalPrice);
            updateTotalPrice(totalPrice, seri);
        },
        error: function (xhr, status, error) {
            // Xử lý lỗi (nếu có)
            console.log(error);
        }
    });
}

function updateTotalPrice(totalPrice, seri) {
    // Update the total price cell with the new value
    var totalCell = document.getElementById("total" + seri);
    totalCell.innerHTML = '<fmt:formatNumber type="currency" value="' + totalPrice + '" currencyCode="VND" maxFractionDigits="0" />';
}

function incrementValue(seri, price) {
    var input = document.getElementById("quantityInput" + seri);
    var value = parseInt(input.value);
    value += 1;
    input.value = value;
    updateCart(seri, price);
}

function decrementValue(seri, price) {
    var input = document.getElementById("quantityInput" + seri);
    var value = parseInt(input.value);
    if (value > 1) {
        value -= 1;
    }
    input.value = value;
    updateCart(seri, price);
}
