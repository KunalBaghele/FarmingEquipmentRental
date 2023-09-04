const Contact = () =>{
    return (
        <>
        <div>
  <div className="page-heading contact-heading header-text" style={{backgroundImage: 'url(images/heading-4-1920x500.jpg)'}}>
    <div className="container">
      <div className="row">
        <div className="col-md-12">
          <div className="text-content">
            <h4>Equipment rental</h4>
            <h2>Contact Us</h2>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div className="find-us">
    <div className="container">
      <div className="row">
        <div className="col-md-12">
          <div className="section-heading">
            <h2>Our Location on Maps</h2>
          </div>
        </div>
        <div className="col-md-8">
          <div id="map">
          <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3783.4240087316625!2d73.80988637348668!3d18.509731769508576!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3bc2c065a7c56561%3A0xe6e0299d0330dcf9!2sInfoway%20Technologies%20Private%20Limited!5e0!3m2!1sen!2sin!4v1692641489501!5m2!1sen!2sin" width="100%" height="330px" style={{border:0}} allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
            {/* <iframe src="https://maps.google.com/maps?q=Av.+L%C3%BAcio+Costa,+Rio+de+Janeiro+-+RJ,+Brazil&t=&z=13&ie=UTF8&iwloc=&output=embed" width="100%" height="330px" frameBorder={0} style={{border: 0}} allowFullScreen /> */}
          </div>
        </div>
        <div className="col-md-4">
          <div className="left-content">
            <h4>About our office</h4>
            <p>Lorem ipsum dolor sit amet, consectetur adipisic elit. Sed voluptate nihil eumester consectetur similiqu consectetur.<br /><br />Lorem ipsum dolor sit amet, consectetur adipisic elit. Et, consequuntur, modi mollitia corporis ipsa voluptate corrupti.</p>
            {/* <ul className="social-icons">
              <li><a href="#"><i className="fa fa-facebook" /></a></li>
              <li><a href="#"><i className="fa fa-twitter" /></a></li>
              <li><a href="#"><i className="fa fa-linkedin" /></a></li>
              <li><a href="#"><i className="fa fa-behance" /></a></li>
            </ul> */}
          </div>
        </div>
      </div>
    </div>
  </div>
  <div className="send-message">
    <div className="container">
      <div className="row">
        <div className="col-md-12">
          <div className="section-heading">
            <h2>Send us a Message</h2>
          </div>
        </div>
        <div className="col-md-8">
          <div className="contact-form">
            <form id="contact" action method="post">
              <div className="row">
                <div className="col-lg-12 col-md-12 col-sm-12">
                  <fieldset>
                    <input name="name" type="text" className="form-control" id="name" placeholder="Full Name" required />
                  </fieldset>
                </div>
                <div className="col-lg-12 col-md-12 col-sm-12">
                  <fieldset>
                    <input name="email" type="text" className="form-control" id="email" placeholder="E-Mail Address" required />
                  </fieldset>
                </div>
                <div className="col-lg-12 col-md-12 col-sm-12">
                  <fieldset>
                    <input name="subject" type="text" className="form-control" id="subject" placeholder="Subject" required />
                  </fieldset>
                </div>
                <div className="col-lg-12">
                  <fieldset>
                    <textarea name="message" rows={6} className="form-control" id="message" placeholder="Your Message" required defaultValue={""} />
                  </fieldset>
                </div>
                <div className="col-lg-12">
                  <fieldset>
                    <button type="submit" id="form-submit" className="filled-button">Send Message</button>
                  </fieldset>
                </div>
              </div>
            </form>
          </div>
        </div>
        <div className="col-md-4">
          <img src="../../images/admin.jpg" className="img-fluid" style={{mixBlendMode:'hard-light',cursor:''}} alt="Admin Image" />
          <h5 className="" style={{marginTop: '1px', marginLeft:'45px'}}>Administrator</h5>
        </div>
      </div>
    </div>
  </div>
</div>

        </>
    )
}

export default Contact;