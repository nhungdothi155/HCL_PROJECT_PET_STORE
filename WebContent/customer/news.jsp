<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
 <html class="no-js">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/search.css">
        <!-- google fonts -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;500;600;700&family=Raleway:wght@300;400;500;700;900&display=swap" rel="stylesheet">
    </head>
    <body>     
        <div class="content">
            <div class="container">              
                <main>
                    <section class = "main-container-left">
                        <h2>Top Stories</h2>
                        <div class = "container-top-left">
                            <article>
                                <img src = "https://static.standard.co.uk/2021/03/16/12/16120545-9a55acaa-6df8-49a0-8904-99a3154d6df4.jpg?width=990&auto=webp&quality=75&crop=968%3A645%2Csmart">
        
                                <div>
                                    <h3>Texas dog awarded by fire department, animal services for saving his owner’s life</h3>
        
                                    <p>Cat owners across the UK could face £500 fines if they fail to get their pets microchipped under new government plans.</p>
        
                                    <a href = "https://www.standard.co.uk/news/uk/cats-microchip-covid-dogs-theft-b929892.html">Read More <span>>></span></a>
                                </div>
                            </article>
                        </div>
        
                        <div class = "container-bottom-left">
                            <article>
                                <img src = "https://static.standard.co.uk/2021/03/16/12/16120545-9a55acaa-6df8-49a0-8904-99a3154d6df4.jpg?width=990&auto=webp&quality=75&crop=968%3A645%2Csmart">
                                <div>
                                    <h3>Cat owners could be fined £500 if they fail to microchip their pets</h3>
                                    <p>Kennel specialized in breeding Labrador retrievers</p>
        
                                    <a href = "https://www.foxnews.com/us/kentucky-kennel-fire-kills-more-than-fifty-dogs">Read More <span>>></span></a>
                                </div>
                            </article>
        
                            <article>
                                <img src = "https://static.standard.co.uk/2021/01/13/15/newFile-2.jpg?width=990&auto=webp&quality=75&crop=968%3A645%2Csmart">
                                <div>
                                    <h3>Best products for dogs; coats, toys, collars and grooming essentials</h3>
                                    <p>Because our four-legged family members like presents too!</p>
        
                                    <a href = "https://www.standard.co.uk/shopping/esbest/home-garden/pets/best-products-for-dogs-coats-toys-collars-grooming-b855770.html">Read More <span>>></span></a>
                                </div>
                            </article>
                        </div>
                    </section>
                    <section class = "main-container-right">  
                        <div class="content__search">
                            <ul>
                                <li><a class="active" onclick="findAll()">All News</a></li>
                                <li><a onclick='findDog()'>Dog</a></li>
                                <li><a onclick="findCat()">Cat</a></li>
                                <li><a onclick="findOther()">More</a></li>
                              </ul>    
                        </div>            
                        
                        
                    </section>
                </main>
                    
                <div class="content__paging">
                    <div class="page">
                       <ul>
                            <li class="btn-prev btn-active fas fa-angle-left"></li>
                            <div class="number-page" id="number-page">
                            <li class="active">
                                <a>1</a>
                            </li>
                            <li>
                                <a>2</a>
                            </li>
                            <li>
                                <a>3</a>
                            </li>
                            </div>
                            <li class="btn-next fas fa-angle-right"></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>      

        <script>
            var allArticle=[{title: "Owner fined for not sending sick dog to vet until it had to be euthanised", 
                            description: "SINGAPORE — A district court on Wednesday (March 24) fined a 51-year-old woman S$2,500 for failing to seek veterinary treatment for her dog for two months after she first noticed a growing lump on her pet", 
                            link: "https://www.todayonline.com/singapore/owner-fined-not-sending-sick-dog-vet-until-it-had-be-euthanised", 
                            image: "https://www.todayonline.com/sites/default/files/styles/new_app_article_detail/public/photos/43_images/20190925_mikhail-vasilyev-ifxjddqk_0u-unsplash.jpg?itok=DL0avs3i"},
                                
                            {title: "Cats like people! (Some people, anyway)", 
                            description: "OREGON — In the perennial battle over dogs and cats, there’s a clear public relations winner", 
                            link: "https://www.todayonline.com/world/cats-people-some-people-anyway", 
                            image: "https://www.todayonline.com/sites/default/files/styles/new_app_article_detail/public/photos/43_images/20190925_mikhail-vasilyev-ifxjddqk_0u-unsplash.jpg?itok=DL0avs3i"},

                            {title: "Electric collars for dogs inhumane and should be banned", 
                            description: "I write in response to Mr Gerald Tan Han Jie’s letter, “Don’t ban e-collars for dogs; educate owners or regulate use instead” (Nov 8)", 
                            link: "https://www.todayonline.com/voices/electric-collars-dogs-inhumane-and-should-be-banned", 
                            image: "https://www.todayonline.com/sites/default/files/styles/new_app_article_detail/public/photos/43_images/lettercollar_1_0.jpg?itok=Mb85_l1U"},

                            {title: "This Brand New Toy Improves Your Pets’ Health & Happiness… You Won’t Believe How Genius It Is", 
                            description: "If you’re a pet owner, then you know just how much your dog or cat craves your love and attention. It’s easy to give them that when you’re at home", 
                            link: "https://petball-trainer.org/en-o/?dicbo=v1-c64fae0dbb4ef22225e0bd458d60f946-005833f6276b99f1f0d2575d8ea01a594c-hbsggnlcgy4toljtmvrdeljumvrgillbmiygkljtg5sdemzwmmztknzwg4", 
                            image: "https://petball-trainer.org/wp-content/uploads/2021/03/main1.jpg"},

                            {title: "Stolen dog found tied up in bag, shaking in terror and buried under sticks", 
                            description: "XCLUSIVE: Poor Mabel the Maltese dog was lost and hound as she recovers at home after being dognapped, tied up and dumped - found whimpering in some bushes down a remote lane", 
                            link: "https://www.mirror.co.uk/news/uk-news/stolen-dog-found-tied-up-24016881", 
                            image: "https://i2-prod.mirror.co.uk/incoming/article24016889.ece/ALTERNATES/s810/0_IMG_0032.jpg"},

                            {title: "", 
                            description: "", 
                            link: "", 
                            image: ""}
                            ];
            function findAll(){
                allArticle.forEach(function(element){
                    var text= "<article>"
	  		+ "                 <h4>just in </h4>"
	  		+ "                  <div>"
	  		+ "                  <h2>"+element.title+"</h2>"
	  		+ "                  <p>"+element.description+"</p>"
	  		+ "                   <a href = "+element.link+">Read More <span>>></span></a>"
	  		+ "                </div>"
	  		+ "                  <img src = "+element.image+">"
	  		+ "                </article>"
	  		+ "        "
                    document.getElementsByClassName("main-container-right").innerHtml +=text;
                    }    
                );
            }
            function findDog(){
                allArticle.forEach(function(element){
                    if(element.title.toLocaleLowerCase().includes("dog")){
                        var text= "<article>"
	  		+ "                 <h4>just in </h4>"
	  		+ "                  <div>"
	  		+ "                  <h2>"+element.title+"</h2>"
	  		+ "                  <p>"+element.description+"</p>"
	  		+ "                   <a href = "+element.link+">Read More <span>>></span></a>"
	  		+ "                </div>"
	  		+ "                  <img src = "+element.image+">"
	  		+ "                </article>"
	  		+ "        "
                    document.querySelectorAll(".main-container-right").innerHtml +=text;
                        }
                    }    
                );
            }
            function findDog(){
                allArticle.forEach(function(element){
                    if(element.title.toLocaleLowerCase().includes("cat")){
                        var text= "<article>"
	  		+ "                 <h4>just in </h4>"
	  		+ "                  <div>"
	  		+ "                  <h2>"+element.title+"</h2>"
	  		+ "                  <p>"+element.description+"</p>"
	  		+ "                   <a href = "+element.link+">Read More <span>>></span></a>"
	  		+ "                </div>"
	  		+ "                  <img src = "+element.image+">"
	  		+ "                </article>"
	  		+ "        "
                    document.getElementsByClassName("main-container-right").innerHtml +=text;
                        }
                    }    
                );
            }
            function findDog(){
                allArticle.forEach(function(element){
                    if(!element.title.toLocaleLowerCase().includes("dog")&&
                    !element.title.toLocaleLowerCase().includes("cat")){
                        var text= "<article>"
	  		+ "                 <h4>just in </h4>"
	  		+ "                  <div>"
	  		+ "                  <h2>"+element.title+"</h2>"
	  		+ "                  <p>"+element.description+"</p>"
	  		+ "                   <a href = "+element.link+">Read More <span>>></span></a>"
	  		+ "                </div>"
	  		+ "                  <img src = "+element.image+">"
	  		+ "                </article>"
	  		+ "        "
                    document.getElementsByClassName("main-container-right").innerHTML +=text;
                        }
                    }    
                );
            }
        
        </script>
    </body>
</html>