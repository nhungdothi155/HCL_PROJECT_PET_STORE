<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="<%=request.getServletContext().getContextPath() %>/customer/css/cart.css">
</head>
<body>
   <div class="cart">
    <div class="split left">
        <table>
           <tr>
            <th>PRODUCT</th>
            <th>PRICE</th>
            <th>QUANTITY</th>
            <th>REMOVE</th>
           </tr>
           <tr>
               <td><img src="https://res.cloudinary.com/mhmd/image/upload/v1556670479/product-1_zrifhn.jpg" alt="" width="70" ></td>
                <td><strong>$79.00</strong></td>
                <td><input type="number"></td>
                <td><a href="#" class="text-dark"><i class="fa fa-trash" style="color: black;"></i></a></td>
            </tr>
        </table>
        <button>Continue seeing product</button>
    </div>
    <div class="split right">
        <form>
            <h4>ORDER SUMMARY</h4>
            <div class="suborder"><strong>Sub Order</strong></div>
            <div class="total"><strong>Total</strong></div>
            <button style="background-color:#27d9ab ;">Procceed To Checkout</button>
          </form>
    </div>

   </div>
    
</body>
</html>