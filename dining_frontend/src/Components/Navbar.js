import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from 'axios';
import { url } from "./URL/constant";
import "./Navbar.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faSearch } from "@fortawesome/free-solid-svg-icons";

const Navbar =() =>{

    const [foodname, setFoodName] = useState("")
    const navigate = useNavigate();

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

    return(
        <div className="navbar-container">
            <div className="restro-name">
                Velvet Victory
            </div>
            <div className="search-container">
                    <FontAwesomeIcon icon={faSearch} className="search-icon" style={{ marginRight : "5px"}}/>
                    <input className="search-box" placeholder = "Search for restaurant, cuisine, or a dish" 
                            value={foodname} onChange={(e) => { setFoodName(e.target.value) }}
                            onKeyDown={handleKeyDown}
                            >
                    </input>
            </div>
            <div className="content" style={{ marginLeft : "50px", fontSize : "20px", fontWeight : "100px", fontFamily: "Sans-serif"}}>
                Login
            </div>
            <div className="content" style={{ marginLeft : "50px", fontSize : "20px", fontWeight : "100px", fontFamily: "Sans-serif"}}>
                SignUp
            </div>
        </div>
        
    )
}
export default Navbar;