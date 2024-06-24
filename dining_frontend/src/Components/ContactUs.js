import React from "react";
import { MDBInput, MDBCheckbox, MDBBtn ,MDBTextArea} from 'mdb-react-ui-kit';
import "./ContactUs.css";
import cookies_1 from '../Images/cookies_1.avif';

const ContactUs = () =>{

    return(
        <div className="container">

            <div className="imageContainer" >
                <img className = "forImage" src={cookies_1}></img>
                <h1 className="overlayText">We would love to hear from you!</h1>
            </div>

            <form id='form' className='text-center' style={{ width: '100%', maxWidth: '600px', marginTop : '20px', marginLeft : '350px'}}>
    
                <MDBInput placeholder="Name" v-model='name' wrapperClass='mb-4' />
        
                <MDBInput type='email' placeholder="Email" v-model='email' wrapperClass='mb-4' />
        
                <MDBInput placeholder="Subject" v-model='subject' wrapperClass='mb-4' />
        
                <MDBTextArea wrapperClass='mb-4' placeholder="Message" />
        
                <MDBBtn color='success' block className='my-4'>
                    Submit Feedback
                </MDBBtn>
            </form>
        </div>
    )
}
export default ContactUs;