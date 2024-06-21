import React from "react";
import "./AboutUs.css";
import About_us1 from '../Images/About_us1.jpg';
import About_us2 from '../Images/About_us2.jpg';

const AboutUs = () => {

    return(

        <div className="container">
            <div className="imageContainer">
                <img className = "forImage" src={About_us1}></img>
                <h1 className="overlayText">Better Food For More People</h1>
            </div>

            <br />

            <div className="para">
                <h3>Driving the force of assortment</h3>
                <p>
                For over a decade now, we’ve been empowering our customers in discovering new tastes and experiences across countries.
                 By putting together meticulous information for our customers, we enable them to make an informed choice.
                </p>
            </div>

            <br />

            <div >
                <div className="para2">
                    <h2>Who Are We?</h2>
                    <p>
                    Launched in 2010, Our technology platform connects customers, restaurant partners and delivery partners,
                    serving their multiple needs. Customers use our platform to search and discover restaurants, read and write customer
                    generated reviews and view and upload photos, order food delivery, book a table and make payments while dining-out at
                    restaurants. On the other hand, we provide restaurant partners with industry-specific marketing tools which enable
                    them to engage and acquire customers to grow their business while also providing a reliable and efficient last mile
                    delivery service. We also operate a one-stop procurement solution, Hyperpure, which supplies high quality
                    ingredients and kitchen products to restaurant partners. We also provide our delivery partners with transparent 
                    and flexible earning opportunities.
                    </p>
                </div>
                <div className="para3">
                    <img className = "forImage" src={About_us2}></img>
                </div>
            </div>
        </div>
    )
}
export default AboutUs;