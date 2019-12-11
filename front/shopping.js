const NUM_PRODS = 10;
getProducts();

function getProducts() {
    var listProducts = document.getElementById("listProducts");
    for (var i = 0; i < NUM_PRODS; i++) {
        var productDOM = [
            document.createElement("div"),  // 0
            document.createElement("div"),  // 1
            document.createElement("div"),  // 2
            document.createElement("a"),    // 3
            document.createElement("img"),  // 4
            document.createElement("div"),  // 5
            document.createElement("div"),  // 6
            document.createElement("div"),  // 7
            document.createElement("h4"),   // 8
            document.createElement("div"),  // 9
            document.createElement("div"),  // 10
            document.createElement("div"),  // 11
            document.createElement("p"),    // 12
        ]

        productDOM[4].src = "./img/P-IMAGE.png"                // Imagem do produto
        productDOM[4].alt = "Titulo do produto"                // Titulo do produto

        productDOM[3].href = "./product.html"                                // href para o produto
        productDOM[3].appendChild(productDOM[4]);

        productDOM[2].className = "product-img";
        productDOM[2].appendChild(productDOM[3]);

        productDOM[8].textContent = "Titulo do produto"        // Titulo do produto
        
        productDOM[7].className = "product-title";
        productDOM[7].appendChild(productDOM[8]);
        
        productDOM[9].className = "product-price";
        productDOM[9].textContent = "Preço"                     // Preço do produto

        productDOM[6].className = "product-title-price";
        productDOM[6].appendChild(productDOM[7]);
        productDOM[6].appendChild(productDOM[9]);

        productDOM[12].textContent = "Descrição do produto"     // Descrição do produto
        
        productDOM[11].className = "product-cart;"
        productDOM[11].appendChild(productDOM[12]);
        
        productDOM[10].className = "product-cart-categori";
        productDOM[10].appendChild(productDOM[11]);
        
        productDOM[5].className = "product-content";
        productDOM[5].appendChild(productDOM[6]);
        productDOM[5].appendChild(productDOM[10]);

        productDOM[1].className = "single-product mb-35";
        productDOM[1].appendChild(productDOM[2]);
        productDOM[1].appendChild(productDOM[5]);

        productDOM[0].className = "custom-col-5 custom-col-style";
        productDOM[0].appendChild(productDOM[1]);
        productDOM[0].id = "product_" + i;

        listProducts.appendChild(productDOM[0]);
    }

}

function botaoTeste() {
    for (var i = 1; i < NUM_PRODS; i++) {
        if (document.getElementById("product_" + i).style.display === "none") {
            document.getElementById("product_" + i).style.display = "block";
        } else {
            document.getElementById("product_" + i).style.display = "none";
        }
    }
}