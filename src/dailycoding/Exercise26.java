package dailycoding;

import java.util.*;

public class Exercise26 {
  public static void main(String[] args) {
    Node root = new Node("1");
    Node rootChild1 = root.addChildNode(new Node("2"));
    Node rootChild2 = root.addChildNode(new Node("3"));
    Node leaf1 = rootChild1.addChildNode(new Node("4"));
    Node leaf2 = rootChild1.addChildNode(new Node("5"));

    ArrayList<String> output = dfs(root);
    System.out.println(output);
  }
  public static ArrayList<String> dfs(Node node) {
    // TODO:
    // 전달받은 노드의 자식이 있는지 확인한다.(getChildren 이 null 이 아닌 경우)
    // 자식이 있다면 방문 순서를 저장하는 리스트에도 저장한다.
    // 자식 노드는 다시 현재 노드가 된다.
    // 현재 노드의 자식이 있는지 확인한다.
    // 전달받은 노드의 자식이 없다면 인접한 노드가 있는지 확인한다.(부모 노드의 children 중 다음 노드)
    ArrayList<String> answer = new ArrayList<>();
    Stack<Node> stack = new Stack<>();

    stack.push(node);
    answer.add(node.getValue());

    while (!stack.isEmpty()) {
      Node currNode = stack.pop();

      if (currNode.getChildrenNode() != null) {
        ArrayList<Node> children = currNode.getChildrenNode();
        for (int i = children.size()-1; i >= 0; i++) {
          stack.push(children.get(i));
          answer.add(children.get(i).getValue());
        }
      }
    }

    return answer;
  }

  //아래 클래스의 내용은 수정하지 말아야 합니다.
  public static class Node {
    private String value;
    private ArrayList<Node> children;

    public Node(String data) {
      this.value = data;
      this.children = null;
    }

    public Node addChildNode(Node node) {
      if(children == null) children = new ArrayList<>();
      children.add(node);
      return children.get(children.size() - 1);
    }

    public String getValue() {      //현재 노드의 데이터를 반환
      return value;
    }

    public ArrayList<Node> getChildrenNode() {
      return children;
    }
  }
}
