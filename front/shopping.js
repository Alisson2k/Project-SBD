getProducts();

function getProducts() {
    for (var i = 0; i < 6; i++) {
        var putHere = document.getElementById("putHere");
        var img = document.createElement("img");
        img.src = "./img/P-IMAGE.png";

        var div1 = document.createElement("div");
        div1.className = "product-img";
        div1.appendChild(img);

        var div2 = document.createElement("div");
        div2.className = "single-product mb-35";
        div2.appendChild(div1);

        var div3 = document.createElement("div");
        div3.className = "custom-col-5 custom-col-style";
        div3.appendChild(div2);
        
        putHere.appendChild(div3);
    }
}

{/* <div class="custom-col-5 custom-col-style">
    <div class="single-product mb-35">
        <div class="product-img">
            <a href="">
                <img src="./img/P-IMAGE.png" alt="">
            </a>
        </div>
        <div class="product-content">
            <div class="product-title-price">
                <div class="product-title"><h4>Product title</h4>
            </div>
            <div class="product-price">100,00</div>
        </div>
            <div class="product-cart-categori">
                <div class="product-cart"><p>Some quick example text to build on the card title and make up the bulk of the card's content.</p></div>
            </div>
        </div>
    </div>
</div> */}