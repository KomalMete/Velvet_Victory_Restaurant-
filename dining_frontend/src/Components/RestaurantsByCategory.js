import { useState , useEffect} from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import { url } from "./URL/constant";
import "./HomePage.css";

const RestaurantsByCategory = () => {

    const { categoryId } = useParams();
    const [restaurants, setRestaurants] = useState([]);

    useEffect(() =>{
        init()
    }, [categoryId])

    const init =() => {
        axios.get(`${url}/restaurant/getAllRestaurantsFromFoodCategory`,
        {
            params: { foodCategoryId: categoryId }
        })
        .then(response => {
            console.log('Printing product data', response.data.response);
            setRestaurants(response.data.response)
        })
        .catch(error =>{
            console.log('Something went wrong in get all reastaurants with categories', error);
        })
        
    }
    return(
        <div className="container">
             <div className="imageContainer">
                
            </div>
            
            <div className="row g-3 p-5 ">
                
                <h2>Eat what makes you happy</h2>
                    {restaurants.map((item) => (
                        <div className="col-4">
                            <div key={item.id}>
                                    <div >
                                        <div  >
                                         <img className="restaurant-images" src={item.restaurantImage} height={250} width={300} style={{paddingBottom : 5}}/> 
                                            <h5>{item.restaurantName}</h5> 
                                        </div> 
                                        
                                    </div>
                            </div>
                        </div>
                    ))}
                
            </div>
        </div>
    )

}

export default RestaurantsByCategory;