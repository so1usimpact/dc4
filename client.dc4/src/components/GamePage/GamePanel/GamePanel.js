import React, {Component} from "react";

import ConnectFourBoard from "./ConnectFourBoard";
import Pieces from "./Pieces";
import Arrows from "./Arrows";

export default class GamePanel extends Component {
  render() {
    return (
      <div className="GamePanel">
        <svg
            id="game-panel"
            viewBox="0 0 7 7"
            width="500px"
            height="500px"
            onMouseMove={this.props.container.onMouseMove}
            onMouseOut={this.props.container.onMouseOut}
            onClick={this.props.container.onClick}
        >
          <ConnectFourBoard />
          <Pieces gameState={this.props.gameState} />
          {(this.props.myTurn) ? <Arrows hoveredCol={this.props.hoveredCol} /> : null}
        </svg>
      </div>
    )
  }
}
