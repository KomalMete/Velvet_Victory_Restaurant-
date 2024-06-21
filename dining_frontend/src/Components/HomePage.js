import { useState } from "react";
import "./HomePage.css";
import HomePage_Image1 from "../Images/HomePage_Image1.webp"


const HomePage =() =>{

    return(
        <div className="container">
            <div className="imageContainer">
                <img className = "forImage" src={HomePage_Image1}></img>
                <h1 className="overlayText">Velvet Victory</h1>
            </div>
        </div>
    )
}
export default HomePage;