import { useState, useEffect } from "react";
import "./Restaurant.css";
import HomePage_Image1 from "../Images/HomePage_Image1.webp"
import { useNavigate } from "react-router-dom";
import About_us1 from '../Images/About_us1.jpg';
import axios from 'axios';
import { url } from "./URL/constant";
import { useParams } from "react-router-dom";

const Restaurant =() => {

    //const [category, setCategory] = useState([]);
    const { restaurantId } = useParams();
    const [food, setFood] = useState([]);
    const [restaurantName, setRestaurantName] = useState("");

    const navigate = useNavigate();

    useEffect(() =>{
        init()
    }, [])

    const init =() => {
        axios.get(`${url}/food/getAllFoodOfRestaurant`,
        {
            params: { restaurantId: restaurantId }
        })
        .then((response) => {
            console.log("Printing product data", response.data.response);
            setFood(response.data.response);
            
    
            if (response.data.response) {
              setRestaurantName(response.data.response[0].restaurantName);
              console.log(response.data.response[0].restaurantName)
            }
          })
        .catch(error =>{
            console.log('Something went wrong in get all categories', error);
        })
    }

    return(
        <div className="container">
            <div className="row g-3 p-5 "  >
                    {food.map((item) => (
                        <div className="col-3" key={item.id}>
                            <div>
                                <img src={item.image} width={250} height={150}/>
                            </div> 
                        </div>
                    ))}
            </div>

            <div className="restaurant">
                 <h2>{restaurantName}</h2>
            </div>
        </div>
    )

}
export default Restaurant;