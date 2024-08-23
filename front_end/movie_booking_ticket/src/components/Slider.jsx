import React from "react";
import { Carousel } from 'react-responsive-carousel';
import "react-responsive-carousel/lib/styles/carousel.min.css";

function Slider() {
  return (
    <Carousel
      showArrows={true}
      infiniteLoop={true}
      showThumbs={false}
      showStatus={false}
      autoPlay={true}
      interval={6000}
    >
      <div>
        <img src="./slider1.jpg" alt="First slide" />
      </div>
      <div>
        <img src="./slider2.jpg" alt="Second slide" />
      </div>
    </Carousel>
  );
}

export default Slider;