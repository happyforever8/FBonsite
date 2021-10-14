The problem is to implement two reddit features, being able to upvote/downvote a 
post and being able to get x top posts. For the "post" structure it can be as simple as an id and number of votes.

something like this:

class Post  {
	int id;
	int upvotes;
}

class Reddit {
	public void upvoteDownvote(int postID) {
	}
 
	public List<Integer> getTopKPosts(int k) {
	}
}




public static void main(String[] args) {
        RedditUpvoteSystem r = new RedditUpvoteSystem();
        r.upVote(1);
        r.upVote(2);
        r.upVote(3);
        r.downVote(2);
        r.upVote(2);
        r.upVote(2);

        System.out.println(r.getTopKPosts(2));

    }

    // Space: O(N) + O(N); N: total inserted posts
    // Time:
    // upvote/downvote: O(N log N)
    // gettopk: O(K)

    // Key = total votes
    // value = total posts for number of votes
    private TreeMap<Integer, Set<Integer>> posts;

    // Key = post Id, value = total votes
    private Map<Integer, Integer> votes;

    public RedditUpvoteSystem() {
        // max first
        this.posts = new TreeMap<>(Collections.reverseOrder());
        this.votes = new HashMap<>();
    }

    public void upVote(int postID) {
        upvoteDownvote(postID, 1);
    }

    public void downVote(int postID) {
        upvoteDownvote(postID, -1);
    }

    // Time: O(1) + O(n log n)
    private void upvoteDownvote(int postID, int value) {
        if (!votes.containsKey(postID)) {
            votes.put(postID, value);
            Set<Integer> postIds = posts.getOrDefault(value, new HashSet<>());
            postIds.add(postID);
            posts.put(value, postIds);
        } else {
            int oldVote = votes.get(postID);
            int newVote = oldVote + value;
            votes.put(postID, newVote);
            posts.get(oldVote).remove(postID);

            Set<Integer> postIds = posts.getOrDefault(newVote, new HashSet<>());
            postIds.add(postID);
            posts.put(newVote, postIds);
        }
    }

    // Time: O(K)
    public List<Integer> getTopKPosts(int k) {
        List<Integer> topKPosts = new ArrayList<>();
        for (Set<Integer> ps : posts.values()) {
            for (Integer p : ps) {
                topKPosts.add(p);
                if (--k == 0) {
                    break;
                }
            }
        }
        return topKPosts;
    }
}
