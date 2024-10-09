import { useState } from "react";
import React from "react";
import "./Footer.css";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faFacebook, faInstagram, faTwitter } from '@fortawesome/free-brands-svg-icons';
import res_logo from '../Images/res_logo.jpg';
import { Link } from "react-router-dom";
import { 
    MDBFooter, 
    MDBContainer, 
    MDBRow, 
    MDBCol, 
    MDBIcon 
  } from 'mdb-react-ui-kit';

const Footer =()=>{

    return(
        

    <MDBFooter  className='text-center text-lg-start text-muted' style={{ backgroundColor: 'rgba(0, 0, 0, 0.05)' }}>
      <section className='text-center p-4' style={{ backgroundColor: 'rgba(0, 0, 0, 0.05)' }}>
        <MDBContainer className='text-center text-md-start mt-5' style={{ backgroundColor: 'rgba(0, 0, 0, 0.05)' }}>
          <MDBRow className='mt-3' >
            <MDBCol md="3" lg="4" xl="3" className='mx-auto mb-4' style={{marginTop : '55px'}}>
              <h6 className='text-uppercase fw-bold mb-4' style={{ fontWeight : 250, fontSize: '34px', marginTop : '45px'}}>
                <MDBIcon icon="gem" className="me-3"  />
                <a href='/'>
                  Velvet Victory
                </a>
              </h6>
            </MDBCol>

            <MDBCol md="2" lg="2" xl="2" className='mx-auto mb-4' style={{marginTop : '55px'}}>
              <h6 className='text-uppercase fw-bold mb-4'>Get to know us</h6>
              <p>
                <a href='aboutus' className='text-reset'>
                  About Us
                </a>
                
              </p>
              <p>
                <a href='contactus' className='text-reset'>
                  Contact Us
                </a>
              </p>
            
            </MDBCol>

            <MDBCol md="3" lg="2" xl="2" className='mx-auto mb-4' style={{marginTop : '55px'}}>
              <h6 className='text-uppercase fw-bold mb-4'>Connect Us</h6>
              <p>
              <a href="https://www.facebook.com">
                    <FontAwesomeIcon icon={faFacebook} />
                </a>
                &nbsp;&nbsp;
                <a href="https://www.instagram.com">
                    <FontAwesomeIcon icon={faInstagram} />
                </a>
                &nbsp;&nbsp;
                <a href="https://twitter.com">
                    <FontAwesomeIcon icon={faTwitter} />
                </a>
                &nbsp;&nbsp;
              </p>
            </MDBCol>

            <MDBCol md="4" lg="3" xl="3" className='mx-auto mb-md-0 mb-4' style={{marginTop : '55px'}}>
              <h6 className='text-uppercase fw-bold mb-4'>Contact</h6>
              <p>
                <MDBIcon icon="home" className="me-2" />
                Pune, India.
              </p>
              <p>
                <MDBIcon icon="envelope" className="me-3" />
                velvetvictory@gmail.com
              </p>
              <p>
                <MDBIcon icon="phone" className="me-3" /> + 01 234 567 88
              </p>
              <p>
                <MDBIcon icon="print" className="me-3" /> + 01 234 567 89
              </p>
            </MDBCol>
          </MDBRow>
        </MDBContainer>
      </section>

      <div className='text-center p-4' style={{ backgroundColor: 'rgba(0, 0, 0, 0.05)' }}>
        © 2024 Copyright:
        <a className='text-reset fw-bold' href='/'>
          velvetvictory.com
        </a>
      </div>
    </MDBFooter>
    );
}
export default Footer;