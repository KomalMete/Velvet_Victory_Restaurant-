import { useState } from "react";
import "./HomePage.css";
import HomePage_Image1 from "../Images/HomePage_Image1.webp"
import About_us1 from '../Images/About_us1.jpg';


const HomePage =() =>{

    return(
        <div className="container">
            <div className="imageContainer">
                <img className = "forImage5" src={HomePage_Image1}></img>
                <h1 className="overlayText5">Velvet Victory</h1>
            </div>
        </div>
    )
}
export default HomePage;