import { useState, useEffect } from "react";
import "./HomePage.css";
import HomePage_Image1 from "../Images/HomePage_Image1.webp"
import About_us1 from '../Images/About_us1.jpg';
import axios from 'axios';
import { url } from "./URL/constant";

const HomePage =() =>{

    const [category, setCategory] = useState([]);

    useEffect(() =>{
        init()
    }, [])

    const init =() => {
        axios.get(url + "/velvet/getAllFoodCategory")
        .then(response => {
            console.log('Printing product data', response.data);
            setCategory(response.data)
        })
        .catch(error =>{
            console.log('Something went wrong', error);
        })
    }

    return(
        <div className="container">
            <div className="imageContainer">
                <img className = "forImage5" src={HomePage_Image1}></img>
                <h1 className="overlayText5">Velvet Victory</h1>
            </div>

            <div>
                {category.map((item) =>{
                   <div key={item.id}>{item.categoryName}</div>
                })}
            </div>
        </div>
    )
}
export default HomePage;