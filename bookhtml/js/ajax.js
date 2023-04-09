
function books(){
    $.ajax({
        url: 'http://localhost:8080/api/book/list',
        type: 'GET',
        success:function (book){
            let row='';
            for (let i = 0; i <book.length; i++) {
                row +=`<tr><td>  ${book[i].name} </td><td>  ${book[i].author} </td><td>  ${book[i].price} </td><td>  ${book[i].code}  </td><td>
\t\t\t\t\t\t\t<div class="dropdown open">
\t\t\t\t\t\t\t\t<a href="#!" class="px-2" id="triggerId1" data-toggle="dropdown" aria-haspopup="true"
\t\t\t\t\t\t\t\t\t\taria-expanded="false">
\t\t\t\t\t\t\t\t\t\t\t<i class="fa fa-ellipsis-v"></i>
\t\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t\t<div class="dropdown-menu" aria-labelledby="triggerId1">
\t\t\t\t\t\t\t\t\t<a class="dropdown-item" href="#"><i class="fa fa-pencil mr-1"></i> Edit</a>
\t\t\t\t\t\t\t\t\t<a class="dropdown-item text-danger" href="#"><i class="fa fa-trash mr-1"></i> Delete</a>
\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t</td></tr>`
            }    document.getElementById("content").innerHTML=row
        }
    })

}books();
function totalPrice(){
    $.ajax({
        url: 'http://localhost:8080/api/book/total-price',
        type: 'GET',
        success:function (total){
           document.getElementById("total").innerHTML=total+"đ";
        }

    })

}totalPrice()
function createBook(){
    let name = $('#name').val();
    let code = $('#code').val();
    let author = $('#author').val();
    let price = $('#price').val();
    let newBook = {
        "name": name,
        "code": code,
        "author": author,
        "price": price
    }
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/book/create",
        data: JSON.stringify(newBook),
        headers: {
            "Content-Type":"application/json",
            "Accept":"application/json"
        },
        success:function (){
            alert("ok");
            books();
        }
    })
    event.preventDefault();
}