function get(URL, PARAMS) {
    var temp = document.createElement("form");
    temp.method = "get";
    temp.style.display = "none";
    var data = "?";
    for (var x in PARAMS) {
        data += x + "=" + PARAMS[x] + "&";
    }
    data = data.slice(0, data.length - 1);
    temp.action = URL + data;
    document.body.appendChild(temp);
    temp.submit();
    return temp;
}