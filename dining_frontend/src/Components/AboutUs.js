import React from "react";
import "./AboutUs.css";
import About_us1 from '../Images/About_us1.jpg';
import About_us2 from '../Images/About_us2.jpg';
import work1 from '../Images/work1.jpg';
import work2 from '../Images/work2.jpg';
import work3 from '../Images/work3.jpg';
import work4 from '../Images/work4.png';
import work5 from '../Images/work5.webp';

const AboutUs = () => {

    return(

        <div className="container">
            <div className="imageContainer">
                <img className = "forImage2" src={About_us1}></img>
                <h1 className="overlayText1">Better Food For More People</h1>
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

            <div className="flex_container">
                <div>
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
                    <img className = "forImage1" src={About_us2}></img>
                </div>
            </div>

            <div>
                <div className="para4">
                    <h2>Glimpses of life at Velvet Victory</h2>
                </div>

                <div className="flex_container1">
                        <img className="officeImage" src={work1}></img>
                        <img className="officeImage"  src={work2}></img>
                        <img className="officeImage"  src={work5}></img>
                </div>
                
                <div className="flex_container2">
                        <img className="officeImage"  src={work3}></img>
                        <img className="officeImage"  src={work4}></img>
                </div>
            </div>
        </div>
    )
}
export default AboutUs;