import { useState, useEffect } from "react";
import "./HomePage.css";
import HomePage_Image1 from "../Images/homePageZomatoImage.png"
import { useNavigate } from "react-router-dom";
import axios from 'axios';
import { url } from "./URL/constant";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faSearch } from "@fortawesome/free-solid-svg-icons";

const HomePage =() =>{

    const [category, setCategory] = useState([]);
    const [restaurants, setRestaurants] = useState([]);
    const [foodname, setFoodName] = useState("")

    const handleSearch =()=> {
        if(foodname.trim())
        {
            navigate(`${url}/food/searchByFoodName/${foodname}`)
        }
    }

    const handleKeyDown = (e) => {
        if (e.key === "Enter") {
          handleSearch();
        }
      };

    const navigate = useNavigate();

    useEffect(() =>{
        init()
    }, [])

    const init =() => {
        axios.get(url + "/velvet/getAllFoodCategory")
        .then(response => {
            console.log('Printing product data', response.data.response);
            setCategory(response.data.response)
        })
        .catch(error =>{
            console.log('Something went wrong in get all categories', error);
        })
        
        axios.get(url + "/restaurant/getAllRestaurants")
        .then(response => {
            console.log('Printing product data', response.data.response);
            setRestaurants(response.data.response)
        })
        .catch(error =>{
            console.log('Something went wrong in get all restaurants', error);
        })
    }

    return(
        <div className="container">
            <div className="imageContainer">
                <img className = "forImage5" src={HomePage_Image1}></img>
                <h1 className="overlayText5">Velvet Victory</h1>
                <div className="search-container">
                    <FontAwesomeIcon icon={faSearch} className="search-icon" style={{ marginRight : "5px"}}/>
                    <input className="search-box" placeholder = "Search for restaurant, cuisine, or a dish" 
                            value={foodname} onChange={(e) => { setFoodName(e.target.value) }}
                            onKeyDown={handleKeyDown}
                            >
                    </input>
            </div>
            </div>
            
            <div className="row g-3 p-5 "  >
                <h2>Eat what makes you happy</h2>
                    {category.map((item) => (
                        <div className="col-3" >
                            <div key={item.id}>
                                    <div >
                                        <div onClick={() => navigate(`/restaurants_cat/${item.id}`)}>
                                            
                                            <img className="category-images" src={item.category_image} width={150} height={120} style={{borderRadius: "50%"}} />
                                            <h5 className="category-images">{item.categoryName}</h5> 
                                        </div> 
                                    </div>
                            </div>
                        </div>
                    ))}
            </div>

            <div className="row g-3 p-5 ">
                <h2>Food Delivery Restaurants</h2>
                {restaurants.map((item) => (
                        <div className="col-4" >
                            <div key={item.id} >
                                    <div style={{textAlign: "center"}}>
                                        <div onClick={() => navigate(`/restaurant/${item.id}`)}>
                                            <img className="restaurant-images" src={item.restaurantImage} height={250} width={300} style={{paddingBottom : 5}}/> 
                                            <h5 >{item.restaurantName}</h5>
                                        </div>
                                    </div>
                            </div>
                        </div>
                    ))}
            </div>
        </div>
    )
}
export default HomePage;