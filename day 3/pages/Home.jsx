import Footer from '../components/Footer'
import Navbar from '../components/Navbar'
import '../assets/css/Home.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import img1 from '../assets/images/Yogahomeimg.jpg'
import img2 from '../assets/images/yogahome2img.jpg'
import { useState, useEffect } from 'react'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faCheck } from '@fortawesome/free-solid-svg-icons'
import { faHeartbeat } from '@fortawesome/free-solid-svg-icons'
import { faBalanceScale } from '@fortawesome/free-solid-svg-icons'
import { faOm } from '@fortawesome/free-solid-svg-icons'
import { faLightbulb } from '@fortawesome/free-solid-svg-icons'
const Home = () => {
  // Define state variables for changeable text
  const [quote, setQuote] = useState('')
  const [typedQuote, setTypedQuote] = useState('')
  const [currentIndex, setCurrentIndex] = useState(0)

  // Dummy data for demonstration
  const quotes = [
    'Inhale the future, exhale the past.',
    'The body benefits from movement, and the mind benefits from stillness.',
    'Yoga is the journey of the self, through the self, to the self.',
  ]

  useEffect(() => {
    // Set initial quote
    setQuote(quotes[Math.floor(Math.random() * quotes.length)])
  }, [])

  useEffect(() => {
    // Type out the quote character by character
    const interval = setInterval(() => {
      if (currentIndex < quote.length) {
        setTypedQuote((prevTypedQuote) => prevTypedQuote + quote[currentIndex])
        setCurrentIndex((prevIndex) => prevIndex + 1)
      } else {
        clearInterval(interval)
      }
    }, 100) // Adjust typing speed as needed

    return () => clearInterval(interval) // Clear interval on component unmount
  }, [quote, currentIndex])
  return (
    <>
      <Navbar />
      <div className="home-background">
        <div className=" container mt-3">
          <div className="row">
            <div className="col-6 mt-5 align-items-center justify-content-center">
              <div className=" ">
                <h1>
                  <span className='disabled'>Welcome to</span> <span className="uppercase-text">ZenVibes</span>
                </h1>
                &ensp; &ensp;
                <h3 className="container pt-5 letter-spacing fw-bold ">
                  {quote}
                </h3>
                <button className="btn btn-outline-info btn-sm">
                  15 Day Free Trial
                </button>
                {/* <p>Today's Highlight: {classHighlight}</p> */}
                {/* <p>Don't miss: {eventHighlight}</p> */}
              </div>
            </div>
            <div className="col-6 mt-4 mb-4 d-flex align-items-center justify-content-center">
              <img
                src={img1}
                alt=""
                className="img-fluid rounded-4"
                style={{ maxHeight: '500px', maxWidth: '100%', height: 'auto' }}
              />
            </div>
          </div>
          <hr />
          <div className="row">
            <div className="col-6 mt-4 mb-4 d-flex align-items-center justify-content-center">
              <img
                src={img2}
                alt=""
                className="img-fluid rounded-4"
                style={{ maxHeight: '500px', maxWidth: '100%', height: 'auto' }}
              />
            </div>
            <div className="col-6 mt-3">
              <h2 className="fw-lighter">Why You Should Go To Yoga</h2>
              <br />
              <p className="letter-spacing disabled">
                Far far away, behind the word mountains, far from the countries
                Vokalia and Consonantia, there live the blind texts. Separated
                they live in Bookmarksgrove right at the coast of the Semantics,
                a large language ocean.
              </p>
              <br />
              <ul className="fs-5">
                <li>
                  <FontAwesomeIcon icon={faCheck} />
                  &nbsp; Yoga boost brain power{' '}
                </li>{' '}
                <br />
                <li>
                  <FontAwesomeIcon icon={faCheck} />
                  &nbsp;Yoga helps you to breathe better
                </li>
                <br />
                <li>
                  <FontAwesomeIcon icon={faCheck} />
                  &nbsp; Yoga improves your strength
                </li>
                <br />
                <li>
                  <FontAwesomeIcon icon={faCheck} />
                  &nbsp;Yoga helps you to focus{' '}
                </li>
              </ul>
            </div>
          </div>{' '}
          <br />
          <hr /> <br />
          <div className="row">
            <div className="col-3 d-flex flex-column align-items-center justify-content-center">
              <FontAwesomeIcon icon={faHeartbeat} size="4x" /> <br />
              <h5 className="fw-bold">Healthy Lifestyle</h5>
              <br />
              <p className="disabled">
                A small river named Duden flows by their place and supplies it
                with the necessary regelialia. It is a paradisematic country
              </p>
            </div>
            <div className="col-3 d-flex flex-column align-items-center justify-content-center">
              <FontAwesomeIcon icon={faBalanceScale} size="4x" /> <br />
              <h5 className="fw-bold">Body & Mind Balance</h5>
              <br />
              <p className="disabled">
                A small river named Duden flows by their place and supplies it
                with the necessary regelialia. It is a paradisematic country
              </p>
            </div>
            <div className="col-3 d-flex flex-column align-items-center justify-content-center">
              <FontAwesomeIcon icon={faOm} size="4x" /> <br />
              <h5 className="fw-bold">Meditation Practice</h5>
              <br />
              <p className="disabled">
                A small river named Duden flows by their place and supplies it
                with the necessary regelialia. It is a paradisematic country
              </p>
            </div>
            <div className="col-3 d-flex flex-column align-items-center justify-content-center">
              <FontAwesomeIcon icon={faLightbulb}  size='4x'/> <br />
              <h5 className="fw-bold">Edeology</h5>
              <br />
              <p className="disabled">
                A small river named Duden flows by their place and supplies it
                with the necessary regelialia. It is a paradisematic country
              </p>
            </div>
          </div>
        </div>
      </div>{' '}
      <br />
      <br />
      <Footer />
    </>
  )
}

export default Home
