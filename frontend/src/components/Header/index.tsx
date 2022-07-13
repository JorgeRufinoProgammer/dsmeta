import logo from '../../assets/img/logo.svg';
import './styles.css';

function Header() {
    return (
        <header>
            <div className="dsmeta-logo-container">
                <img src={logo} alt="DSMeta" />
                <h1>DSMeta</h1>
                <p>
                    Desenvolvido por Jorge Rufino <br />                
                    <a href="https://github.com/JorgeRufinoProgammer">@github/JorgeRufinoProgammer</a><br />                
                    <a href="https://www.linkedin.com/in/jorge-rufino-ab156434/">@linkedin/JorgeRufino</a>
                </p>
            </div>
        </header>
    )
}

export default Header;