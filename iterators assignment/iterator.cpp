#include <iostream>
#include <string>
#include <map> 
#include <utility>
using namespace std;


int main(){

	map<string, int> marks{ { "Corey", 85 },
	{ "Jimmy", 91 }, { "Rob", 100 },
	{ "Jill", 58 }, { "Jack", 54 }, { "Larry", 66}};



	map<string, int>::iterator i;
	cout << "The Student's marks are " << endl;
	for (i = marks.begin(); i != marks.end(); i++){
		cout << i->second << " ";
		cout << endl;
	}


}