// package piece;

// import java.util.List;

// import board.Grid;

// public class RuleSet implements IRule {
//     private List<IRule> movesets;

//     public RuleSet(List<IRule> movesets) {
//         this.movesets = movesets;
//     }

//     @Override
//     public boolean canGo(Grid from, Grid to) {
//         return movesets.stream().allMatch(m -> m.canGo(from, to));
//     }

//     public IRule negate() {
//         return (from, to) -> ! this.canGo(from, to);
//     }

//     public void add(IRule rule) {
//         movesets.add(rule);
//     }

//     public RuleSet and(IRule other) {
//         movesets.add(other);
//         return this;
//     }
// }
