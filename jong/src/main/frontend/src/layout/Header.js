import  Pages  from "../data/Pages";
import styled, { css } from 'styled-components';
import theme from '../styles/Theme';
import { Link, useNavigate } from "react-router-dom";

const Header=( { history } )=>{




    return(        
        <Container>
        <Link to="/"><Button> 메인페이지 </Button></Link>
            {Pages.map(data => {
                return(
                    <Link to={data.name}>
                        <Button name={data.name} key={data.id}>
                            {data.text}
                        </Button>
                    </Link>
                )
            })}
        </Container>
    )
}

export default Header;

const Container = styled.div`
  ${theme.flex.flexBox}
  height: 50px;
`;

const Button = styled.button`
  padding: 1px 2px;
  margin: 10px;
  color: #111111;
  background-color: #eeeeee;
  border-radius: 5px;
`;

